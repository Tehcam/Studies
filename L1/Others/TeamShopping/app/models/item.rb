require 'pubnub'

class Item < ApplicationRecord
    belongs_to :rayon

    @@pubnub = Pubnub.new(
        subscribe_key: "sub-c-828cd53c-bfc3-11eb-aee1-fe487e55b6a4",
        publish_key: "pub-c-9ce10d1f-f958-426a-bd74-849e495aa82b",
        uuid: "sec-c-YzNmMTViY2EtNTgwZS00Y2FkLTllOWEtYWQ4MDdiNjQyYmEw")

    def to_s
        label
    end

    def post_notification
        @@pubnub.publish channel: 'courses', message:{title: 'TeamShopping', content: is_already_bought, id: id}
    end

end
