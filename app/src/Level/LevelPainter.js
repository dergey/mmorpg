import React, {Component} from 'react';
import {Group, Rect, Stage, Text} from "react-konva";
import LevelObject from "../LevelObject/LevelObject";
import Life from "../Life/Life";
import {loadSprite} from "../helpers/sprites-loader";

const ARROW_LEFT_KEY = 37;
const ARROW_UP_KEY = 38;
const ARROW_RIGHT_KEY = 39;
const ARROW_DOWN_KEY = 40;

class LevelPainter extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            baseSprite: this.props.level.baseSprite,
            viewport: {x: 0, y: 0, width: window.innerWidth, height: window.innerHeight},
            levelWidth: this.props.level.width * this.props.level.levelPointWidth,
            levelHeight: this.props.level.height * this.props.level.levelPointHeight
        };
        this.handleKeyDown = this.handleKeyDown.bind(this);
    }

    componentDidMount() {
        loadSprite(this.state.baseSprite.path)
            .then((image) => {
                const baseSprite = this.state.baseSprite;
                this.setState({
                    baseSprite: {
                        type: baseSprite.type,
                        x: baseSprite.x,
                        y: baseSprite.y,
                        width: baseSprite.width,
                        height: baseSprite.height,
                        image: image
                    },
                    isLoading: false
                });
            });
        document.addEventListener("keydown", this.handleKeyDown, false);
    }

    handleKeyDown(e) {
        const viewport = this.state.viewport;
        if (e.keyCode === ARROW_LEFT_KEY) {
            if (viewport.x > 0) {
                viewport.x = viewport.x - 8;
                this.setState({viewport: viewport});
                this.imageNode.draw();
            }
        } else if (e.keyCode === ARROW_UP_KEY) {
            if (viewport.y > 0) {
                viewport.y = viewport.y - 8;
                this.setState({viewport: viewport});
                this.imageNode.draw();
            }
        } else if (e.keyCode === ARROW_RIGHT_KEY) {
            if (viewport.x < this.state.levelWidth) {
                viewport.x = viewport.x + 8;
                this.setState({viewport: viewport});
                this.imageNode.draw();
            }
        } else if (e.keyCode === ARROW_DOWN_KEY) {
            if (viewport.y < this.state.levelHeight) {
                viewport.y = viewport.y + 8;
                this.setState({viewport: viewport});
                this.imageNode.draw();
            }
        }
    }

    render() {
        if (this.state.isLoading) {
            return <Text x={0} y={0} text={"Loading..."}/>;
        }


        const objectsList = this.props.level.objects.map((object, index) => {
            return (<LevelObject key={index} levelObject={object} viewport={this.state.viewport}/>)
        });
        objectsList.push(<Life key={this.props.player.name} life={this.props.player} viewport={this.state.viewport}/>);

        const spriteOffsetX = this.state.viewport.x % this.state.baseSprite.width;
        const spriteOffsetY = this.state.viewport.y % this.state.baseSprite.height;

        return (
            <Group>
                <Rect
                    x={0}
                    y={0}
                    fillPatternImage={this.state.baseSprite.image}
                    fillPatternRepeat={"repeat"}
                    fillPatternOffsetX={spriteOffsetX}
                    fillPatternOffsetY={spriteOffsetY}
                    width={this.state.viewport.width}
                    height={this.state.viewport.height}
                    ref={node => {
                        this.imageNode = node;
                    }}
                />
                {objectsList}
            </Group>
        );
    }
}

export default LevelPainter;