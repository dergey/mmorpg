import React, {Component} from 'react';
import {Layer, Stage} from "react-konva";
import LevelPainter from "../Level/LevelPainter";

class Game extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            player: null,
            level: null
        };
        this.loadGame = this.loadGame.bind(this);
    }

    componentDidMount() {
        this.loadGame();
    }

    loadGame() {
        fetch('api/home')
            .then(response => response.json())
            .then(data => this.setState({player: data.player,  level: data.level, isLoading: false}));
    }

    render() {
        if (this.state.isLoading) {
            return (<div/>);
        }

        return (
            <div>
                <Stage width={window.innerWidth} height={window.innerHeight}>
                    <Layer>
                        <LevelPainter level={this.state.level} player={this.state.player}/>
                    </Layer>
                </Stage>
            </div>
        );
    }
}

export default Game;