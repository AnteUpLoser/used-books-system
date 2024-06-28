document.getElementById('loginForm').addEventListener('click', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    console.log("已经跳转");
    console.log(username,password)
    axios.post('/user/admin/login', {
            username: username,
            password: password
        })
        .then(function(response) {
            if (response.data.code === 1) {
                console.log(111)
                // Redirect to another page on successful login
                window.location.href = './books.html';
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
