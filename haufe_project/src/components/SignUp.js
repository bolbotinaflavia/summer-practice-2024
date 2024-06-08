import React, { useState } from "react";

const SignUp = () => {

    const [name, setName] = useState("");
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSignUp = (e) => {
        e.preventDefault();
        //signUp auth
    };

    return (
        <div>
            <h2>SignUp</h2>
            <form onSubmit={handleSignUp}>
                <input type="name" placeholder="Enter name" value={name}
                    onChange={(e) => setName(e.target.value)} required />
                <input type="username" placeholder="Enter username" value={username}
                    onChange={(e) => setUsername(e.target.value)} required />
                <input type="email" placeholder="Enter email" value={email}
                    onChange={(e) => setEmail(e.target.value)} required />
                <input
                    input type="password" placeholder="Enter password" value={password}
                    onChange={(e) => setPassword(e.target.value)} required
                />
                <button type="submit">SignUp</button>
            </form>
        </div>
    );

};

export default SignUp;