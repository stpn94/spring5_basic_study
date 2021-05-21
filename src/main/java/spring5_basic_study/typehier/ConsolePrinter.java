package spring5_basic_study.typehier;

public class ConsolePrinter implements Printer {

	@Override
	public void print(String msg) {
		System.out.println(msg);
	}

}
