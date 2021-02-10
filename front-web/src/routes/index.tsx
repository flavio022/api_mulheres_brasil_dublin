import React from "react";
import { Route } from "react-router-dom";
import { Switch } from "react-router-dom";
import SignIn from "../Pages/SignIn";

const Routes: React.FC = () => (
  <Switch>
    <Route path="/" exact component={SignIn} />
  </Switch>
);
export default Routes;
