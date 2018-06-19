package com.example.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Widget {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private String widgetType;
	private String name;
	private int order;
	private String className;
	private String style;
	private String height;
	private String width;
	
	@ManyToOne
	@JsonIgnore
	private Lesson lesson;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getWidgetType() {
		return widgetType;
	}
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
}