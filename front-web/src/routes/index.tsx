import React from "react";

import { Switch } from "react-router-dom";
import Route from "./Route";
import SignIn from "../Pages/SignIn";
import Dashboard from "../Pages/Dashboard";
import FormAdd from "../Pages/FormAdd";

const Routes: React.FC = () => (
  <Switch>
    <Route path="/" exact component={SignIn} />
    <Route path="/dashboard" exact component={Dashboard} isPrivate />
    <Route path="/cadastrar" exact component={FormAdd} isPrivate />
  </Switch>
);
export default Routes;
