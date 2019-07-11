import React, {Component} from 'react';
import {Image, Text} from "react-konva";
import {loadSprite} from "../helpers/sprites-loader";

class LevelObject extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            sprite: this.props.levelObject.sprite
        };
    }

    componentDidMount() {
        loadSprite(this.state.sprite.path)
            .then((image) => {
                const sprite = this.state.sprite;
                this.setState({
                    sprite: {
                        type: sprite.type,
                        x: sprite.x,
                        y: sprite.y,
                        width: sprite.width,
                        height: sprite.height,
                        image: image
                    },
                    isLoading: false
                });
            });
    }

    render() {
        if (this.state.isLoading) {
            return <Text x={0} y={0} text={"Loading..."}/>;
        }

        const objectX = this.props.levelObject.x - this.props.viewport.x;
        const objectY = this.props.levelObject.y - this.props.viewport.y;

        return (
            <Image
                x={objectX}
                y={objectY}
                cropX={this.state.sprite.x}
                cropY={this.state.sprite.y}
                cropWidth={this.state.sprite.width}
                cropHeight={this.state.sprite.height}
                width={this.props.levelObject.width}
                height={this.props.levelObject.height}
                image={this.state.sprite.image}
                ref={node => {
                    this.imageNode = node;
                }}
            />
        );
    }
}

export default LevelObject;