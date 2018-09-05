import de.collin.ObservableList;

public class Main {
	public Main() {
		ObservableList<Integer> list = new ObservableList<>(3, 4, 5);
		var x = list.get(2);
		System.out.println(x);
		list.addAddListener(element -> System.out.println("Once: " + element));
		list.add(6);
		list.addAddListener(element -> System.out.println("Twice" + element));
	}

	public static void main(String[] args) {
		new Main();
	}
}
