from flask import Flask
from flask import send_from_directory

app = Flask(__name__)

@app.route('/hello')
def hello_world():
    return "<p>Hello world</p>"

@app.route('/')
def index():
    return send_from_directory('html', 'index.html')

@app.route('/<path:name>')
def start(name):
    return send_from_directory('html', name)

app.run(debug=True)