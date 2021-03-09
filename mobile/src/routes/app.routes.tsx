import React from "react";
import { createStackNavigator } from "@react-navigation/stack";

import Landing from "../pages/Landing";
import Dashboard from "../pages/Dashboard";
import Section from "../pages/Section";
import Details from "../pages/Details";

const App = createStackNavigator();

const AppRoutes: React.FC = () => (
  <App.Navigator
    screenOptions={{
      headerShown: false,
      cardStyle: { backgroundColor: "#312e38" }
    }}
  >
    <App.Screen name="Dashboard" component={Dashboard} />

    <App.Screen name="Landing" component={Landing} />
    <App.Screen name="Section" component={Section} />
    <App.Screen name="Details" component={Details} />
  </App.Navigator>
);

export default AppRoutes;
