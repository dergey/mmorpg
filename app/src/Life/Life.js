import React, {Component} from 'react';
import {Group, Image, Text} from "react-konva";
import {loadSprite} from "../helpers/sprites-loader";

class Life extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            sprite: this.props.life.sprite
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
        const lifeX = this.props.life.x - this.props.viewport.x;
        const lifeY = this.props.life.y - this.props.viewport.y;

        if (this.state.isLoading) {
            return <Text x={lifeX} y={lifeY} text={"Loading..."} fill={"green"}/>;
        }

        return (
            <Group>
                <Text x={lifeX} y={lifeY - 12} text={this.props.life.name} fill={"green"}/>
                <Image
                    x={lifeX}
                    y={lifeY}
                    cropX={this.state.sprite.x}
                    cropY={this.state.sprite.y}
                    cropWidth={this.state.sprite.width}
                    cropHeight={this.state.sprite.height}
                    width={this.props.life.width}
                    height={this.props.life.height}
                    image={this.state.sprite.image}
                    ref={node => {
                        this.imageNode = node;
                    }}
                />
            </Group>
        );
    }
}

export default Life;