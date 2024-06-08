import React, { useState } from "react";
import api from "../api/axiosConfig";

const Login = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const submitUser = async(e) =>{
        e.preventDefault()
   
        api.post('/api/v1/auth/authenticate', {
            method: 'POST',
            headers: {
                'content-type': 'application/json',
            },
            body: JSON.stringify({ email, password }),
        })
            .then((res) => res.json())
            .then((data) => {
                if (data.body === null) {
                    localStorage.setItem('jwt-token', data.token)
                    setEmail('')
                    setPassword('')
                   // api.push('/api/auth/demo-controller')
                } else {
                    alert(data.message)
                }
            })
    }

 

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={submitUser}>
                <input type="email" placeholder="Enter email" value={email}
                    onChange={(e) => setEmail(e.target.value)} required />
                <input
                    input type="password" placeholder="Enter password" value={password}
                    onChange={(e) => setPassword(e.target.value)} required
                />
                <button type="submit">Login</button>
            </form>
        </div>
    );

};

export default Login;