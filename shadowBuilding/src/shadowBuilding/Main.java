package shadowBuilding;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String filePath="C:\\Users\\B-17\\Desktop\\input.txt";
		int paperNum=0;
		int[] areas=null;
		int sum=0;
		int[][] plane=null;
		try {
			FileReader fileStream = new FileReader(new File(filePath));
			BufferedReader br = new BufferedReader(fileStream);
			char[] data = new char[100];
			String line;
			int i =1;
			
			paperNum = Integer.parseInt(br.readLine());
			int p=1;
			areas = new int[paperNum];
			while((line= br.readLine()) != null) {
				String[] lineArray = line.split(" ");
				
				plane = new int[3000][3000];
				int showingArea=0;

				
					int leftRow = Integer.parseInt(lineArray[0]);
					int leftCol =Integer.parseInt(lineArray[1]);
					int width = Integer.parseInt(lineArray[2]);
					int height = Integer.parseInt(lineArray[3]);
					
					for(int k=leftRow; k<leftRow+width; k++) {
						for(int j=leftCol; j<leftCol+height; j++) {
							if(plane[k][j] != 0) {
								int overwrittenPaper=plane[k][j];
								areas[overwrittenPaper-1]--;
							}
							plane[k][j]=p;
							areas[p-1]++;
							
						}
					}
					p++;
				
					
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		for(int pa=0; pa<paperNum; pa++) {
			System.out.print(areas[pa]+" ");
			sum+=areas[pa];
		}

		System.out.println("°á°ú : "+sum);
	}

}
