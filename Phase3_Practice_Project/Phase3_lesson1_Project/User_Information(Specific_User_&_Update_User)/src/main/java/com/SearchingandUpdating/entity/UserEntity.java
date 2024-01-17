package com.SearchingandUpdating.entity;
import java.math.BigDecimal;
public class UserEntity {
private long id;
private String name;
private BigDecimal salary;
public UserEntity() {
}
public UserEntity(long id, String name, BigDecimal salary) {
super();
this.id = id;
this.name = name;
this.salary = salary;
}
public long getId() {
return id;
}
public void setId(long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public BigDecimal getSalary() {
return salary;
}
public void setSalary(BigDecimal salary) {
this.salary = salary;
}
@Override
public String toString() {
return "UserEntity [id=" + id + ", name=" + name + "]";
}
}
