import React, {Component} from 'react';
import './App.css';

class Home extends Component {

    render() {
        const message = <h2>Добро пожаловать!</h2>;

        return (
            <div>
                {message}
            </div>
        );
    }
}

export default Home;