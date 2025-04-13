package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

// PreparedStatement---CRUD
public class StudentDaoPrep {
    public int insertStudent(StudentBean sbean) {
        String insertQuery = "INSERT INTO students(first_name, last_name, email, phone, dob, gender, address, course, batch_time, payment_mode, sports, music, debate, volunteering) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("insertQuery : " + insertQuery);

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        int rowsAffected = 0;

        if (conn != null) {
            try {
                pstmt = conn.prepareStatement(insertQuery);
                pstmt.setString(1, sbean.getFirstName());
                pstmt.setString(2, sbean.getLastName());
                pstmt.setString(3, sbean.getEmail());
                pstmt.setString(4, sbean.getPhone());
                pstmt.setString(5, sbean.getDob());
                pstmt.setString(6, sbean.getGender());
                pstmt.setString(7, sbean.getAddress());
                pstmt.setString(8, sbean.getCourse());
                pstmt.setString(9, sbean.getBatchTime());
                       
                pstmt.setString(10, sbean.getPaymentMode());
                pstmt.setBoolean(11, sbean.isSports()); 
                pstmt.setBoolean(12, sbean.isMusic());
                pstmt.setBoolean(13, sbean.isDebate());
                pstmt.setBoolean(14, sbean.isVolunteering());

                rowsAffected = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("StudentDaoPrep :: insertStudent() Db not connected");
        }
        return rowsAffected;
    }

    public int updateStudent(StudentBean sbean, int id) {
        String updateQuery = "UPDATE students SET first_name = ?, last_name = ?, email = ?, phone = ?, dob = ?, gender = ?, address = ?, course = ?, batch_time = ?, payment_mode = ?, sports = ?, music = ?, debate = ?, volunteering = ? WHERE student_id = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        int rowsAffected = 0;

        if (conn != null) {
            try {
                pstmt = conn.prepareStatement(updateQuery);
                pstmt.setString(1, sbean.getFirstName());
                pstmt.setString(2, sbean.getLastName());
                pstmt.setString(3, sbean.getEmail());
                pstmt.setString(4, sbean.getPhone());
                pstmt.setString(5, sbean.getDob());
                pstmt.setString(6, sbean.getGender());
                pstmt.setString(7, sbean.getAddress());
                pstmt.setString(8, sbean.getCourse());
                pstmt.setString(9, sbean.getBatchTime());
                pstmt.setString(10, sbean.getPaymentMode());
                pstmt.setBoolean(11, sbean.isSports());
                pstmt.setBoolean(12, sbean.isMusic());
                pstmt.setBoolean(13, sbean.isDebate());
                pstmt.setBoolean(14, sbean.isVolunteering());
                pstmt.setInt(15, id);

                rowsAffected = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("StudentDaoPrep :: updateStudent() Db not connected");
        }
        return rowsAffected;
    }

    public ArrayList<StudentBean> getAllStudentRecords() {
        ArrayList<StudentBean> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM students";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        if (conn != null) {
            try {
                pstmt = conn.prepareStatement(selectQuery);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("student_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String dob = rs.getString("dob");
                    String gender = rs.getString("gender");
                    String address = rs.getString("address");
                    String course = rs.getString("course");
                    String batchTime = rs.getString("batch_time");
                    String paymentMode = rs.getString("payment_mode");
                    boolean sports = rs.getBoolean("sports");
                    boolean music = rs.getBoolean("music");
                    boolean debate = rs.getBoolean("debate");
                    boolean volunteering = rs.getBoolean("volunteering");

                    StudentBean s = new StudentBean(id, firstName, lastName, email, phone, dob, gender, address, course, batchTime, paymentMode, sports, music, debate, volunteering);
                    list.add(s);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("StudentDaoPrep :: getAllStudentRecords() Db not connected");
        }
        return list;
    }

    public StudentBean getStudentById(int id) {
        String selectQuery = "SELECT * FROM students WHERE student_id = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudentBean sbean = null;

        if (conn != null) {
            try {
                pstmt = conn.prepareStatement(selectQuery);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                	
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String dob = rs.getString("dob");
                    String gender = rs.getString("gender");
                    String address = rs.getString("address");
                    String course = rs.getString("course");
                    String batchTime = rs.getString("batch_time");
                    String paymentMode = rs.getString("payment_mode");
                    boolean sports = rs.getBoolean("sports");
                    boolean music = rs.getBoolean("music");
                    boolean debate = rs.getBoolean("debate");
                    boolean volunteering = rs.getBoolean("volunteering");

                    sbean = new StudentBean(id, firstName, lastName, email, phone, dob, gender, address, course, batchTime, paymentMode, sports, music, debate, volunteering);
                } else {
                    System.out.println("Student record not found");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("StudentDaoPrep :: getStudentById() Db not connected");
        }
        return sbean;
        
        
        
    }
    
    
    public int deleteStudent(int id) {
        String deleteQuery = "DELETE  FROM students WHERE student_id = ?";
        PreparedStatement pstmt = null;
        Connection conn = DBConnection.getConnection();
        int rowsAffected = 0;

        if (conn != null) {
            try {
                pstmt = conn.prepareStatement(deleteQuery);
                pstmt.setInt(1, id);
                rowsAffected = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("StudentDaoPrep :: deleteStudent() Db not connected");
        }
        return rowsAffected;
    }

    public static void main(String[] args) {
        StudentDaoPrep dao = new StudentDaoPrep();

        ArrayList<StudentBean> list = dao.getAllStudentRecords();
        for (StudentBean s : list) {
            System.out.println(s.getId() + " " + s.getFirstName() + " " + s.getLastName() + " " + s.getPhone()+ " " + s.getDob() + " " + s.getGender() + " " + s.getAddress()+ " " + s.getCourse() + " " + s.getBatchTime() + " " + s.getPaymentMode()+ " " + s.isSports() + " " + s.isMusic() + " " + s.isDebate()+" "+s.isVolunteering());
        }
    }
}

