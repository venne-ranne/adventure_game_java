package kaukau.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Room implements Serializable{

	@XmlElement(name="name")
	private String name;
	
	private int startX;
	
	private int startY;
	private ArrayList<Door> doors;

	public Room(String name, int x, int y){
		this.name = name;
		this.startX = x;
		this.startY = y;
		doors = new ArrayList<Door>();
	}
	
	public Room(){
		this(null, -1, -1);
	}
	
	public void addDoor(Door door){
		this.doors.add(door);
	}
	
	public void setStartX(int x){
		startX = x;
	}
	
	public void setStartY(int y){
		startY = y;
	}
	
	public void setDoors(){
		
	}
	
	@XmlElement(name="startX")
	public int getStartX(){
		return startX;
	}
	
	@XmlElement(name="startY")
	public int getStartY(){
		return startY;
	}
	
	public ArrayList<Door> getDoors(){
		return doors;
	}
	
	public Point getStartPoint(){
		return new Point(startX, startY);
	}
	
	public String getName(){ return name; }
}
