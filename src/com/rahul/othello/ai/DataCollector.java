/**
 * 
 */
package com.rahul.othello.ai;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.rahul.othello.Board;
import com.rahul.othello.Point;
import com.rahul.othello.Tournament;

/**
 * @author rahular Feb 5, 2015
 */
public class DataCollector {
	private static ObjectOutputStream oos;
	private static ArrayList<DataBlob> data;

	public static void setup() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(
					"./data/" + System.currentTimeMillis())));
			data = new ArrayList<DataBlob>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void write(Board board, double evalScore, Point nextMove) {
		DataBlob dataBlob = new DataBlob((Board) board.clone(), evalScore, nextMove);
		data.add(dataBlob);
		// System.out.println(dataBlob);
	}
	
	public static void save() {
		try {
			oos.writeObject(data);
			if(Tournament.debug) 
				System.out.println("Wrote " + data.size() + " rows.");
			terminate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void terminate() {
		try {
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<DataBlob> read(String fileName) {
		try {
			return (ArrayList<DataBlob>) new ObjectInputStream(new FileInputStream(
					new File("./data/" + fileName))).readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
