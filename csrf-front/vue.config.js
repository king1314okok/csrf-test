module.exports = {
    devServer: {
        host: 'localhost',
        port: 8080,
        proxy: {
            '/api': {
                target: 'http://localhost:8089/api/',
                changOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    }
}