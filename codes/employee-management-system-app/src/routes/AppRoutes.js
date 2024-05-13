import React from 'react'
// import { Route, Routes, createBrowserRouter} from 'react-router-dom'
import { useRoutes } from 'react-router-dom'
import Home from "../components/common/home/Home";
import EmployeeList from "../components/employee/employee-list/EmployeeList";
import AddEmployee from "../components/employee/add-employee/AddEmployee";
import UpdateEmployee from "../components/employee/update-employee/UpdateEmployee";
import EmployeeDetail from "../components/employee/employee-detail/EmployeeDetail";
import PageNotFound from "../components/common/page-not-found/PageNotFound";

/*
const AppRoutes = () => {
    return (
        <Routes>
            <Route path='*' element={<PageNotFound />} />
            <Route path='home' element={<Home />} />
            <Route path='' element={<Home />} />
            <Route path='employees'>
                <Route path='' element={<EmployeeList />} />
                <Route path='view/:id' element={<EmployeeDetail />} />
                <Route path='add' element={<AddEmployee />} />
                <Route path='update/:id' element={<UpdateEmployee />} />
            </Route>

        </Routes>
    )
}
*/

const AppRoutes = () => {

    const appRoutes = useRoutes([
        {
            path: '',
            element: <Home />,
            children: [
                {
                    path: 'home',
                    element: <Home />
                }
            ]
        },
        {
            path: '*',
            element: <PageNotFound />
        },
        {
            path: 'employees',
            children: [
                {
                    path: '',
                    element: <EmployeeList />
                },
                {
                    path: 'add',
                    element: <AddEmployee />
                },
                {
                    path: 'view/:id',
                    element: <EmployeeDetail />
                },
                {
                    path: 'update/:id',
                    element: <UpdateEmployee />
                }]
        }
    ])

    return appRoutes;
}
export default AppRoutes