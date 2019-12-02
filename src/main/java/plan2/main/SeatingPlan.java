package plan2.main;
	import java.util.Random;

public class SeatingPlan {


		private String[] names = { "CA", "RR", "MF", "LM", "JG", "HH", "JB", "LP", "LC", "LH", "AM", "AT", "JL", "AR", "ZZ",
				"LC2", "CJ", "JK", "TK", "NV", "AW", "ED", "ER", "xx" };

		private String[][] plan;
		
		 public SeatingPlan(int rowNum, int colNum) {
			 this.plan = new String[rowNum][colNum];
		}

		
		private Random rand = new Random();

		public  void assignSeat() {
			int x = 0;
			int y = 0;
			for (int i = 0; i < names.length; i++) {

				do {

					x = rand.nextInt(4);

					y = rand.nextInt(6);
				} while (plan[x][y] != null);

				plan[x][y] = names[i];

			}
		}

		public String[][] getPlan() {
			return this.plan;
		}

	}

