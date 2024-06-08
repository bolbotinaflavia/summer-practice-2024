import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom"
import './App.css';
import "./components/Login";
import "./components/SignUp";
import Login from "./components/Login";
import SignUp from "./components/SignUp";


function App() {
  return (
      <Router>
          <div>
              <nav>
                  <ul>
                      <li>
                          <h4>Welcome back!</h4>
                          <Link to="/login">Login</Link>
                      </li>
                      <li>
                          <h4>Don't have an accout?</h4>
                          <Link to="/signup">SignUp</Link>
                      </li>
                  </ul>
              </nav>
              <Routes>
                  <Route exact="true" path="/login" element={<Login />} />
                  <Route exact="true" path="/signup" element={<SignUp/>} />
              </Routes>
          </div>
      </Router>
  );
}

export default App;
