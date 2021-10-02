var pubnub;

function letsGo()
{
    pubnub = new PubNub({
        publishKey : "pub-c-9ce10d1f-f958-426a-bd74-849e495aa82b",
        subscribeKey : "sub-c-828cd53c-bfc3-11eb-aee1-fe487e55b6a4",
        uuid : "sec-c-YzNmMTViY2EtNTgwZS00Y2FkLTllOWEtYWQ4MDdiNjQyYmEw"
    })
    pubnub.addListener({
        status: function(statusEvent) {
            console.log('Pubnub ready !')
        },
        message: function(msg) {
            console.log('notification from pubnub')
            var ref = $('#' + msg.message.id)[0]
            var text = msg.message.content ? (ref.dataset.label + " vient d'être acheté(e) !") : (ref.dataset.label + " n'est pas encore acheté(e) !")
            ref.checked = msg.message.content
            alert(msg.message.title + '\n' + text)
        }
    })
    pubnub.subscribe({
        channels: ["courses"]
    })
}

// function postNotification(item, status)
// {
//     var notification = {
//         title: "TeamShopping",
//         content: status ? (item + " vient d'être acheté !") : (item + " n'est pas encore acheté(e) !")
//     }
//     console.log(notification.title)
//     console.log(notification.content)
//     pubnub.publish({
//         message: notification,
//         channel: "courses"
//     })
// }

$('.checkbox').on('click', function(e){
    e.preventDefault();
    var authenticity = $('input[name="authenticity_token"]')[0].defaultValue;
    var bool = e.currentTarget.checked;
    var mydata;
    if(bool)
        mydata = {
            "authenticity_token" : authenticity,
            "is_already_bought" : true
        }
    else
        mydata = {
            "authenticity_token" : authenticity,
            "is_already_bought" : false
        }
    $.ajax({
        type: 'PATCH',
        url: '/items/label/' + e.currentTarget.dataset.label + '.json',
        success: function(res){
            console.log('success')
        },
        dataType: 'json',
        data: mydata
    })
})

letsGo()