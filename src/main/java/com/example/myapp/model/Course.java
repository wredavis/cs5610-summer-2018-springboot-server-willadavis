package com.example.myapp.model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
}
