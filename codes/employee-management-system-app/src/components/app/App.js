import './App.css';
import DashBoard from '../common/dashboard/DashBoard';
import AppRoutes from '../../routes/AppRoutes';
import { Outlet } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <DashBoard />
      <br />
      <div className='container container-fluid'>
        <AppRoutes />
      </div>
    </div>
  );
}

export default App;
