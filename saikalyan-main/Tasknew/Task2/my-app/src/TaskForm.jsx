import React, { useContext, useState } from 'react'
import { TaskContext } from './TaskContextComponent';
function TaskForm({setDisplayForm}) {
    const {tasks,addTask,deleteTask} = useContext(TaskContext);

    // const [task,setTask] = useState({});

    const handleSubmit= (event)=>{
        event.preventDefault();
        let name = event.target.taskName.value;
        let desc = event.target.taskDescription.value;
        console.log(name,desc);

        let new_task={
            "taskId": tasks.length + 1,
            "taskName" : name,
            "taskDescription" : desc
        }
        addTask(new_task);
        setDisplayForm();
        event.target.taskName.value="";
        event.target.taskDescription.value="";
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="exampleInputEmail1" className="form-label">Task</label>
                    <input type="text" name='taskName' className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
                </div>
                <div className="mb-3">
                    <label htmlFor="exampleInputPassword1" className="form-label">Description</label>
                    <input type="text" name='taskDescription' className="form-control" id="exampleInputPassword1"/>
                </div>
                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
        </div>
    )
}

export default TaskForm