import SwiftUI
import shared
import KMPNativeCoroutinesCore
import KMPNativeCoroutinesAsync

final class ContentViewModel: ObservableObject {

    @Published var greetings = [String]()

    @MainActor
    func startObserving() {
        Task {
            do {
                let sequence = asyncSequence(for: Greeting().greet())
                for try await phrase in sequence {
                    greetings.append(phrase)
                }
            } catch {
                print("Error: \(error.localizedDescription)")
            }
        }
    }

}

struct ContentView: View {

    @StateObject
    private var viewModel = ContentViewModel()

	var body: some View {
        List(viewModel.greetings, id: \.self) {
		    Text($0)
		}
        .onAppear {
            viewModel.startObserving()
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
