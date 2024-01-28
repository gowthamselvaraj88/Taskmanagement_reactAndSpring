import React, { useEffect, useState } from "react";
import '../TaskView/TaskView.css';
import NavbarComponent from "../Navbar/NavbarComponent";
import { Button, Card, Divider } from 'antd';
import axios from "axios";
import { Link, useLocation } from "react-router-dom";

function TaskView() {
    const [pendingtasks, setPendingtasks] = useState([]);
    const [completedtask, setCompletedtasks] = useState([]);

    const token = window.sessionStorage.getItem('authToken')

    const authToken = {
        'Authorization': `Bearer ${token}`,
        'authToken': `${token}`
    }


    useEffect(() => {
        const fetchPendingTasks = async () => {
            try {
                const response = await axios.get("http://localhost:8080/tasks/findbypending", { headers: authToken })
                    .then(response => {
                        setPendingtasks(response.data)
                    });

            } catch (err) {
                console.log(err.response.status);
                const status = err.response.status;
                if (status == 401) {
                    alert("Only Login Users allowed!")
                } else {
                    alert("Error!")
                }
            }
        }

        fetchPendingTasks();
    }, []);

    useEffect(() => {
        const fetchCompletedTasks = async () => {
            try {
                const response = await axios.get("http://localhost:8080/tasks/findbycompleted", { headers: authToken })
                    .then(response => {
                        setCompletedtasks(response.data)
                    });

            } catch (err) {
                const status = err.response.status;
                if (status == 401) {
                    alert("Only Login Users allowed!")
                } else {
                    alert("Error!")
                }
            }
        }

        fetchCompletedTasks();
    }, []);

    const handleSubmit = async (id) => {

        try {
            await axios.put(`http://localhost:8080/tasks/statusupdate/${id}`, { headers: authToken.authToken })
            window.location.reload();
        } catch (err) {
            const status = err.response.status;
            if (status == 401) {
                alert("Only Login Users allowed!")
            } else {
                alert("Cannot Submit")
            }

        }
    }

    const handleDelete = async (id) => {

        try {
            await axios.delete("http://localhost:8080/tasks/delete/" + id, { headers: authToken })
            window.location.reload()
        } catch (err) {
            const status = err.response.status;
            if (status == 401) {
                alert("Only Login Users allowed!")
            } else {
                alert("Cannot Delete!")
            }

        }
    }


    return (
        <div>
            <NavbarComponent />
            <div className="add_button">
                <Button className="button_name" type="primary"><Link className="links" to={'/add'}>Add Task</Link></Button>
            </div>
            <div className="tasks">
                <div className="pending">
                    <h3>Pending Tasks</h3>
                    <div className="pending_cards">
                        {pendingtasks.map((task, i) => (
                            <div key={i} className="cards">
                                <Card
                                    title={task.title}
                                    style={{
                                        width: 280,
                                    }}
                                    extra={<Button onClick={() => handleSubmit(task.taskId)} type="primary">Submit Task</Button>}
                                >
                                    <h5>Description</h5>
                                    <p> {task.description}</p>
                                    <p><span>Start Date :</span> {task.startDate}</p>
                                    <p><span>End Date :</span> {task.endDate}</p>
                                    <div className="card_button">
                                        <Button><Link to={`/edit/${task.taskId}`}>Edit</Link></Button>
                                        <Button onClick={() => handleDelete(task.taskId)} type="primary" danger>Delete</Button>
                                    </div>
                                </Card>
                            </div>
                        ))}


                    </div>
                </div>
                <Divider type="vertical" style={{ height: "100vh" }} />
                <div className="completed">
                    <h3>Completed Tasks</h3>
                    <div className="completed_cards">
                        {completedtask.map((task, i) => (
                            <div className="cards">
                                <Card
                                    title={task.title}
                                    style={{
                                        width: 280,
                                    }}
                                >
                                    <h5>Description</h5>
                                    <p> {task.description}</p>
                                    <p><span>Start Date :</span> {task.startDate}</p>
                                    <p><span>End Date :</span> {task.endDate}</p>
                                    <div className="card_button">
                                        <Button onClick={() => handleDelete(task.taskId)} type="primary" danger>Delete</Button>
                                    </div>
                                </Card>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    )
}

export default TaskView;