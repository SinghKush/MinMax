import java.util.Scanner;
import java.io.*;


class Finder1 {
	String [] items = new String[99];
	int [] wt = new int[99];
	int [] val = new int[99];
	int i = 0;
	int j = 0;
	int k = 0;

	private Scanner readInfo;
	private Scanner readInfo2;
	private Scanner readInfo3;
	private Scanner readInfo4;
	private Scanner readInfo5;
	private Scanner readInfo6;
	private Scanner readInfo7;
	private Scanner readInfo8;
	private Scanner readInfo9;

	public void openCodesFile1() {
		try {
			readInfo = new Scanner(new File("C:/Users/Kush Singh/Google Drive/College/Programs & Stuff/Pennapps XVII/TacoBellItems.txt"));
		} catch (Exception e) {
			System.out.println("Could not locate the data file!");
		}
	}

  public String[] readCodesFile1() {

		while(readInfo.hasNext()) {
			items[i] = readInfo.next();
			i++;
		}
		return items;
    }

	public void closeCodesFile1() {
		readInfo.close();
	}

	public void openCodesFile2() {
		try {
			readInfo2 = new Scanner(new File("C:/Users/Kush Singh/Google Drive/College/Programs & Stuff/Pennapps XVII/TacoBellCosts.txt"));
		} catch (Exception e) {
			System.out.println("Could not locate the data file!");
		}
	}

  public int[] readCodesFile2() {

		while(readInfo2.hasNext()) {
			wt[j] = readInfo2.nextInt();
			j++;

		}
		return wt;
    }

	public void closeCodesFile2() {
		readInfo2.close();
	}
	public void openCodesFile3() {
		try {
			readInfo3 = new Scanner(new File("C:/Users/Kush Singh/Google Drive/College/Programs & Stuff/Pennapps XVII/TacoBellCalories.txt"));
		} catch (Exception e) {
			System.out.println("Could not locate the data file!");
		}
	}

  public int[] readCodesFile3() {

		while(readInfo3.hasNext()) {
			val[k] = readInfo3.nextInt();
			k++;
		}
		return val;
    }

	public void closeCodesFile3() {
		readInfo3.close();
	}

	public void openCodesFile4() {
		try {
			readInfo4 = new Scanner(new File("C:/Users/Kush Singh/Google Drive/College/Programs & Stuff/Pennapps XVII/CFAItems.txt"));
		} catch (Exception e) {
			System.out.println("Could not locate the data file!");
		}
	}

  public String[] readCodesFile4() {

		while(readInfo4.hasNext()) {
			items[i] = readInfo4.next();
			i++;
		}
		return items;
    }

	public void closeCodesFile4() {
		readInfo4.close();
	}

	public void openCodesFile5() {
		try {
			readInfo5 = new Scanner(new File("C:/Users/Kush Singh/Google Drive/College/Programs & Stuff/Pennapps XVII/CFACosts.txt"));
		} catch (Exception e) {
			System.out.println("Could not locate the data file!");
		}
	}

  public int[] readCodesFile5() {

		while(readInfo5.hasNext()) {
			wt[j] = readInfo5.nextInt();
			j++;
		}
		return wt;
    }

	public void closeCodesFile5() {
		readInfo5.close();
	}

	public void openCodesFile6() {
		try {
			readInfo6 = new Scanner(new File("C:/Users/Kush Singh/Google Drive/College/Programs & Stuff/Pennapps XVII/CFACalories.txt"));
		} catch (Exception e) {
			System.out.println("Could not locate the data file!");
		}
	}

  public int[] readCodesFile6() {

		while(readInfo6.hasNext()) {
			val[k] = readInfo6.nextInt();
			k++;
		}
		return val;
    }

	public void closeCodesFile6() {
		readInfo6.close();
	}

	public void openCodesFile7() {
		try {
			readInfo7 = new Scanner(new File("C:/Users/Kush Singh/Google Drive/College/Programs & Stuff/Pennapps XVII/MaccasItems.txt"));
		} catch (Exception e) {
			System.out.println("Could not locate the data file!");
		}
	}

  public String[] readCodesFile7() {

		while(readInfo7.hasNext()) {
			items[i] = readInfo7.next();
			i++;
		}
		return items;
    }

	public void closeCodesFile7() {
		readInfo7.close();
	}

	public void openCodesFile8() {
		try {
			readInfo8 = new Scanner(new File("C:/Users/Kush Singh/Google Drive/College/Programs & Stuff/Pennapps XVII/MaccasCosts.txt"));
		} catch (Exception e) {
			System.out.println("Could not locate the data file!");
		}
	}

  public int[] readCodesFile8() {

		while(readInfo8.hasNext()) {
		  wt[j] = readInfo8.nextInt();
			j++;
		}
		return wt;
    }

	public void closeCodesFile8() {
		readInfo8.close();
	}

	public void openCodesFile9() {
		try {
			readInfo9 = new Scanner(new File("C:/Users/Kush Singh/Google Drive/College/Programs & Stuff/Pennapps XVII/MaccasCalories.txt"));
		} catch (Exception e) {
			System.out.println("Could not locate the data file!");
		}
	}

  public int[] readCodesFile9() {

		while(readInfo9.hasNext()) {
			val[k] = readInfo9.nextInt();
			k++;
		}
		return val;
    }

	public void closeCodesFile9() {
		readInfo9.close();
	}
}

public class MinMax
{
    public void solve(int[] wt, int[] val, int W, int N, String[] items)
    {
        int NEGATIVE_INFINITY = Integer.MIN_VALUE;
        int[][] m = new int[N + 1][W + 1];
        int[][] sol = new int[N + 1][W + 1];
				int totCal = 0;
				double totCost = 0;

        for (int i = 1; i <= N; i++)
        {
            for (int j = 0; j <= W; j++)
            {
                int m1 = m[i - 1][j];
                int m2 = NEGATIVE_INFINITY;
                if (j >= wt[i])
                    m2 = m[i - 1][j - wt[i]] + val[i];
                /** select max of m1, m2 **/
                m[i][j] = Math.max(m1, m2);
                sol[i][j] = m2 > m1 ? 1 : 0;
            }
        }
        /** make list of what all items to finally select **/
        int[] selected = new int[N + 1];
        for (int n = N, w = W; n > 0; n--)
        {
            if (sol[n][w] != 0)
            {
                selected[n] = 1;
                w = w - wt[n];
            }
            else
                selected[n] = 0;
        }
        /** Print finally selected items **/
        System.out.println("\nItems selected|Calories|Cost ");
        for (int i = 1; i < N + 1; i++)
            if (selected[i] == 1){
                System.out.println("\n" + items[i] + "|" + val[i] +  "|" + wt[i]);
								totCal += val[i];
								totCost += wt[i];}
				totCost /= (double) 100;
        System.out.println("\nTotal Cost: $" + totCost);
				System.out.println("\nTotal Calories: " + totCal);
    }
    /** Main function **/
    public static void main (String[] args)
    {
				Scanner scan = new Scanner(System.in);
        MinMax ks = new MinMax();

				System.out.println("\nWhere do you want to eat: Taco Bell (1), Chick-Fil-A (2), or McDonalds (3)?");
				int rest = scan.nextInt();

				System.out.println("\nWhat's your budget? ");
        double w = scan.nextDouble();
				int W = (int) w*100;

				if (rest==1){
					int n=56;
					int[] wt = new int[n + 1];
	        int[] val = new int[n + 1];
					String[] items = new String[n+1];
					Finder1 valueFinder = new Finder1();

					valueFinder.openCodesFile1();
					valueFinder.openCodesFile2();
					valueFinder.openCodesFile3();

					items = valueFinder.readCodesFile1();
					wt = valueFinder.readCodesFile2();
					val = valueFinder.readCodesFile3();

					valueFinder.closeCodesFile1();
					valueFinder.closeCodesFile2();
					valueFinder.closeCodesFile3();

					ks.solve(wt, val, W, n,items);
				}

				else if (rest==2){
					int n=27;
					int[] wt = new int[n + 1];
	        int[] val = new int[n + 1];
					String[] items = new String[n+1];

					Finder1 valueFinder = new Finder1();

					valueFinder.openCodesFile4();
					valueFinder.openCodesFile5();
					valueFinder.openCodesFile6();

					items = valueFinder.readCodesFile4();
					wt = valueFinder.readCodesFile5();
					val = valueFinder.readCodesFile6();

					valueFinder.closeCodesFile4();
					valueFinder.closeCodesFile5();
					valueFinder.closeCodesFile6();

					ks.solve(wt, val, W, n,items);
				}

				else if (rest==3){
					int n=41;
					int[] wt = new int[n + 1];
	        int[] val = new int[n + 1];
					String[] items = new String[n+1];

					Finder1 valueFinder = new Finder1();

					valueFinder.openCodesFile7();
					valueFinder.openCodesFile8();
					valueFinder.openCodesFile9();

					items = valueFinder.readCodesFile7();
					wt = valueFinder.readCodesFile8();
					val = valueFinder.readCodesFile9();

					valueFinder.closeCodesFile7();
					valueFinder.closeCodesFile8();
					valueFinder.closeCodesFile9();

					ks.solve(wt, val, W, n,items);
				}
    }
}
