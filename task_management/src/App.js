import TaskView from './component/TaskView/TaskView';
import TaskEdit from './component/TaskEdit/TaskEdit';
import AddTask from './component/AddTask/AddTask' ;
import Login from './component/Login/Login';
import Register from './component/Register/Register'
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';

function App() {
  return (
    <div>

      
      <BrowserRouter>
      <Routes>
        <Route path='/' element={<TaskView/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/register' element={<Register/>}/>
        <Route path='/add' element={<AddTask/>}/>
        <Route path='/edit/:id' element={<TaskEdit/>}/>
        </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
