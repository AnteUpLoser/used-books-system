// JavaScript代码可以在这里添加
const notices = [{
    "id": 1,
    "title": "震惊，今晚维护服务器",
    "content": "因为后端程序员太菜了，今晚宣布维护服务器，网站暂停服务至凌晨5点",
    "notifyTime": 1719133522,
    "updateTime": 1719133522,
    "deleteTime": 1719136497,
    "isDelete": 1
}, {
    "id": 2,
    "title": "系统升级通知",
    "content": "我们将在本周末进行系统升级，预计会影响到网站正常访问，请用户提前做好准备。",
    "notifyTime": 1719133522,
    "updateTime": 1719133522,
    "deleteTime": null,
    "isDelete": 0
}];

const noticeContainer = document.getElementById('notice-container');
const newNoticeBtn = document.getElementById('new-notice-btn');
let isDelete = 0
    // 渲染公告
function renderNotice(noticeContainer,isDelete) {
    axios.get(`/get/cur/bulletins/${isDelete}`)
        .then(response => {
            const notices = response.data.data;
            console.log(notices)
            noticeContainer.innerHTML = ''; // 清空容器
            notices.forEach(notice => {
                const noticeDiv = document.createElement('div');
                noticeDiv.classList.add('notice');
                noticeDiv.innerHTML = `
                    <h3>${notice.title}</h3>
                    <p>${notice.content}</p>
                    <span class="delete-btn" data-id="${notice.id}">删除</span>
                `;
                noticeContainer.appendChild(noticeDiv);
            });
        })
        .catch(error => {
            console.error('获取公告数据时出错', error);
        });
}
renderNotice(noticeContainer,isDelete)
    // 渲染所有公告
    // function renderAllNotices() {
    //     noticeContainer.innerHTML = '';
    //     notices.forEach(notice => {
    //         renderNotice(notice);
    //     });
    // }
    //
    // // 初始化页面时渲染所有公告
    // renderAllNotices();
const announcementTypeSelect = document.getElementById('announcement-type');
// 监听选择框变化
announcementTypeSelect.addEventListener('change', function() {
    const isDelete = this.value;
    console.log(isDelete)
    const del = document.querySelectorAll('.delete-btn')
    if (isDelete == 0) {
        del.forEach(d => d.style.display = 'none');
    } else {

        del.forEach(d => d.style.display = 'block');
    }
    console.log(isDelete)
    renderNotice(noticeContainer,isDelete);
});

// 新建公告按钮点击事件
document.getElementById('new-notice-btn').addEventListener('click', function() {
    document.getElementById('popup').style.display = 'block';
});

document.getElementById('closePopupBtn').addEventListener('click', function() {
    document.getElementById('popup').style.display = 'none';
});

document.getElementById('bulletinForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const title = document.getElementById('title').value;
    const content = document.getElementById('content').value;
    document.getElementById('popup').style.display = 'none';

    axios.post('/add/new/bulletin', {
            title: title,
            content: content
        })
        .then(function(response) {
            console.log('公告已成功添加:', response);
            alert('公告添加成功')
            document.getElementById('popup').style.display = 'none';

            renderNotice(noticeContainer,isDelete);
        })
        .catch(function(error) {
            console.error('添加公告时出错:', error);
        });
});


// 删除公告按钮点击事件
// 删除公告按钮点击事件
noticeContainer.addEventListener('click', (event) => {
    if (event.target.classList.contains('delete-btn')) {
        const noticeId = event.target.dataset.id;

        // 发送删除公告的请求到后端
        axios.post(`/delete/bulletin?id=${noticeId}`)
            .then(response => {
                console.log(`公告 ${noticeId} 已删除`, response);

                // 删除公告成功后，从页面上移除该公告项
                const noticeItem = event.target.closest('.notice');
                noticeContainer.removeChild(noticeItem);
            })
            .catch(error => {
                console.error(`删除公告 ${noticeId} 时出错`, error);
            });
    }
});