import React from "react";
import { BrowserRouter as Router } from "react-router-dom";
import GlobalStyle from "./styles/global";

import Routes from "./routes";
import { AuthProvider } from "./hooks/AuthContext";

import "./App.css";

const App: React.FC = () => (
  <AuthProvider>
    <Router>
      <Routes />
      <GlobalStyle />
    </Router>
  </AuthProvider>
);
export default App;
