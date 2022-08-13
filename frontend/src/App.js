import {Switch,Route,withRouter} from "react-router";
import PrivateRoute from "./route/PrivateRoute";
import Layout from "./layout/Index";

import Error404Classic from "./pages/error/404-classic";
import Error404Modern from "./pages/error/404-modern";
import Error504Modern from "./pages/error/504-modern";
import Error504Classic from "./pages/error/504-classic";

import Login from "./pages/auth/Login";
import {RedirectAs404} from "./utils/Utils";
import Success from "./pages/auth/Success";
import ForgotPassword from "./pages/auth/ForgotPassword";
import Register from "./pages/auth/Register";


const  App=()=>{
    return(
            <Switch>
                {/* Auth Pages */}
                <Route exact path={`${process.env.PUBLIC_URL}/auth-success`} component={Success}></Route>
                <Route exact path={`${process.env.PUBLIC_URL}/auth-reset`} component={ForgotPassword}></Route>
                <Route exact path={`${process.env.PUBLIC_URL}/auth-register`} component={Register}></Route>
                <Route exact path={`${process.env.PUBLIC_URL}/auth-login`} component={Login}></Route>

                {/*Error Pages*/}
                <Route exact path={`${process.env.PUBLIC_URL}/errors/404-classic`} component={Error404Classic}></Route>
                <Route exact path={`${process.env.PUBLIC_URL}/errors/504-modern`} component={Error504Modern}></Route>
                <Route exact path={`${process.env.PUBLIC_URL}/errors/404-modern`} component={Error404Modern}></Route>
                <Route exact path={`${process.env.PUBLIC_URL}/errors/504-classic`} component={Error504Classic}></Route>

                {/*Main Routes*/}
                {/*<PrivateRoute exact path="" component={Layout}></PrivateRoute>*/}
                <Route component={RedirectAs404}></Route>
            </Switch>
    )
}
export default withRouter(App);