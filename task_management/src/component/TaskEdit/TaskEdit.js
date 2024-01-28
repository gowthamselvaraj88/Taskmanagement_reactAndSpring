import { Button, Card, Form, Input, Select, Space } from "antd";
import React, { useEffect, useState } from "react";
import '../AddTask/AddTask.css';
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";

function TaskEdit() {
    const [task,setTask] = useState([])
    const [updatetask, setUpdatetask] = useState({
        title: "",
        description: "",
        startDate: "",
        endDate: ""
    })

    const navigate = useNavigate();
    const location = useLocation()
    
    
    const id = location.pathname.split("/")[2]


    const token = window.sessionStorage.getItem('authToken')

    const authToken = {
        'Authorization': `Bearer ${token}`,
        'authToken': `${token}`
    }

    console.log(authToken)

    const handleChange = (e) => {
        setUpdatetask(prev => ({ ...prev, [e.target.name]: e.target.value }))
    }

    useEffect(() => {
        const fetchTasks = async () => {
            try {
                const response = await axios.get("http://localhost:8080/tasks/get/"+id, { headers: authToken })
                    .then(response => {
                        setTask(response.data)
                    });

            } catch (err) {
                console.log(err);
            }
        }

        fetchTasks();
    }, []);

    const handleClick = async (e) => {
        e.preventDefault()

        try {
            await axios.put("http://localhost:8080/tasks/update/"+id, updatetask, { headers: authToken })
            alert("Task Updated")
            navigate("/")
        } catch (err) {
            console.log(err);
            const status = err.response.status;
            if (status == 401) {
                alert("Only Login Users allowed!")
            } else {
                alert("Cannot Update")
            }
        }

    }


    return (
        <>

<Card className="card">
                <Form
                 layout="vertical"
                >
                    <h3>Edit Task</h3>
                    <div className="input-title">
                        <Form.Item label="Task Title">
                        <Input type="text" className="input-1-field-1"
                            name="title"
                            value={task.title}
                            placeholder="Enter Task Title" onChange={handleChange} />
                        </Form.Item>
                        
                    </div>
                    <div className="input">
                        <Form.Item label="Description">
                        <Input type="text" name="description"
                        value={task.description}
                            placeholder="Enter Description" onChange={handleChange} />
                        </Form.Item>
                    </div>
                    <div className="input-1">
                        <Form.Item label="Start Date">
                        <Input type="date" className="input-1-field-1"
                        value={task.startDate}
                        name="startDate" placeholder="Enter Start Date" onChange={handleChange} />
                        </Form.Item>
                        <Form.Item label="End Date">
                        <Input type="date" name="endDate"
                        value={task.endDate}
                        placeholder="Enter End Date" onChange={handleChange} />
                        </Form.Item>
                    </div>

                    <div className="input">

                    </div>

                    <div className="input">
                        <Button onClick={handleClick} htmlType="submit">Submit</Button>
                    </div>
                </Form>

            </Card>
        </>
    )

}

export default TaskEdit;