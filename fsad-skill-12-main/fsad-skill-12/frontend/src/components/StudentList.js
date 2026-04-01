import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentList() {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/students").then((res) => {
      setStudents(res.data);
    });
  }, []);

  const deleteStudent = async (id) => {
    await axios.delete(`http://localhost:8080/students/${id}`);
    window.location.reload();
  };

  // Update function
  const editStudent = (student) => {
    const newName = prompt("Enter new name", student.name);
    const newEmail = prompt("Enter new email", student.email);
    const newCourse = prompt("Enter new course", student.course);

    axios.put(`http://localhost:8080/students/${student.id}`, {
      name: newName,
      email: newEmail,
      course: newCourse
    }).then(() => {
      window.location.reload();
    });
  };

  return (
    <table border="1">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Course</th>
          <th>Action</th>
        </tr>
      </thead>

      <tbody>
        {students.map((s) => (
          <tr key={s.id}>
            <td>{s.id}</td>
            <td>{s.name}</td>
            <td>{s.email}</td>
            <td>{s.course}</td>

            <td>
              <button onClick={() => deleteStudent(s.id)}>Delete</button>
              <button onClick={() => editStudent(s)}>Update</button>
            </td>

          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default StudentList;