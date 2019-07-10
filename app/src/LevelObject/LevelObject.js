import React, {Component} from 'react';
import {Image, Text} from "react-konva";

class LevelObject extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            sprite: this.props.levelObject.sprite
        };
        this.loadSprite = this.loadSprite.bind(this);
    }

    componentDidMount() {
        this.loadSprite();
    }

    componentWillUnmount() {
        this.spriteImage.removeEventListener('load', this.handleBackgroundImageLoad);
    }

    loadSprite() {
        this.spriteImage = new window.Image();
        this.spriteImage.src = this.state.sprite.path;
        this.spriteImage.addEventListener('load', this.handleBackgroundImageLoad);
    }

    handleBackgroundImageLoad = () => {
        const sprite = this.state.sprite;
        this.setState({
            sprite: {
                type: sprite.type,
                x: sprite.x,
                y: sprite.y,
                spriteWidth: sprite.spriteWidth,
                spriteHeight: sprite.spriteHeight,
                image: this.spriteImage
            },
            isLoading: false
        });
    };

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
                cropWidth={this.state.sprite.spriteWidth}
                cropHeight={this.state.sprite.spriteHeight}
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