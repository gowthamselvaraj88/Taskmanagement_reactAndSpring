import { Button, Card, Form, Input, Select, Space } from "antd";
import React, { useState } from "react";
import './AddTask.css';
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import FormItemLabel from "antd/es/form/FormItemLabel";
import { FormLabel } from "react-bootstrap";

function AddTask() {
    const [addtask, setAddtask] = useState({
        title: "",
        description: "",
        startDate: "",
        endDate: ""
    })

    const navigate = useNavigate();


    const token = window.sessionStorage.getItem('authToken')

    const authToken = {
        'Authorization': `Bearer ${token}`,
        'authToken': `${token}`
    }

    console.log(authToken)

    const handleChange = (e) => {
        setAddtask(prev => ({ ...prev, [e.target.name]: e.target.value }))
    }

    const handleClick = async (e) => {
        e.preventDefault()

        try {
            await axios.post("http://localhost:8080/tasks/add", addtask, { headers: authToken })
            alert("Task Added")
            navigate("/")
        } catch (err) {
            console.log(err);
            alert("Error!")
        }

    }


    return (
        <>

            <Card className="card">
                <Form
                 layout="vertical"
                >
                    <h3>Add Task</h3>
                    <div className="input-title">
                        <Form.Item label="Task Title">
                        <Input type="text" className="input-1-field-1"
                            name="title"
                            placeholder="Enter Task Title" onChange={handleChange} />
                        </Form.Item>
                        
                    </div>
                    <div className="input">
                        <Form.Item label="Description">
                        <Input type="text" name="description"
                            placeholder="Enter Description" onChange={handleChange} />
                        </Form.Item>
                    </div>
                    <div className="input-1">
                        <Form.Item label="Start Date">
                        <Input type="date" className="input-1-field-1" name="startDate" placeholder="Enter Start Date" onChange={handleChange} />
                        </Form.Item>
                        <Form.Item label="End Date">
                        <Input type="date" name="endDate" placeholder="Enter End Date" onChange={handleChange} />
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

export default AddTask;