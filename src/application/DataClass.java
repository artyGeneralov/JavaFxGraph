package application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataClass {

	private String src;

	private ArrayList<String> str_arr = new ArrayList<String>();
	private ArrayList<Integer> int_arr = new ArrayList<Integer>();

	public DataClass(String src) {
		this.src = src;
		fillArrs();
	}

	private void fillArrs() {
		File srcFile = new File(src);
		int_arr.clear();
		str_arr.clear();
		try {
			FileReader in = new FileReader(srcFile);

			int c;
			while ((c = in.read()) != -1) {

				// read the whole line (for simplicities sake)
				String wholeLine = "";
				String name_string = "";
				String num_string = "";
				do {
					//wholeLine += (char) c;
					if(c >= 'A' && c <= 'z')
						name_string+=(char)c;
					else if(c >= '0' && c <='9')
						num_string += Character.valueOf((char)c);
					c = in.read();
				} while (c != '\n' && c != -1);


				String name = name_string;
				Integer num = Integer.parseInt(num_string);
				int_arr.add(num);
				str_arr.add(name);
			}
			in.close();
		} catch (IOException e) {
			System.err.println("Could not open file");
			e.printStackTrace();
		}
	}
	
	public void setSrc(String src) {
		this.src = src;
		fillArrs();
	}
	
	public String[] getStringData() {
		String[] str_dat = new String[str_arr.size()];
		for(int i = 0; i < str_dat.length; i++)
			str_dat[i] = str_arr.get(i);
		return str_dat;
	}
	
	public Integer[] getIntegerData() {
		Integer[] int_dat = new Integer[str_arr.size()];
		for(int i = 0; i < int_dat.length; i++)
			int_dat[i] = int_arr.get(i);
		return int_dat;
		
	}
}
