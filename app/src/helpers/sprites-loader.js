export const spritesMap = new Map();

export function loadSprite(path) {
    return new Promise((resolve, reject) => {
        if (spritesMap.has(path)) {
            console.log("sprite " + path + " load from cache");
            resolve(spritesMap.get(path));
        } else {
            let spriteImage = new window.Image();
            spriteImage.src = path;
            spriteImage.addEventListener('load', () => {
                console.log("sprite " + path + " load from network");
                spritesMap.set(path, spriteImage);
                resolve(spriteImage);
            });
        }
    });
}