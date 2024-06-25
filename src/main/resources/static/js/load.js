document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    window.location.href = './main.html';
    axios.post('https://your-api-endpoint/login', {
            username: username,
            password: password
        })
        .then(function(response) {
            if (response.data.success) {
                // Redirect to another page on successful login
                window.location.href = 'main.html';
            } else {
                // Show an error message
                alert('输入的用户名或密码错误');
            }
        })
        .catch(function(error) {
            console.error('Error during login request:', error);
            alert('An error occurred. Please try again later.');
        });
});