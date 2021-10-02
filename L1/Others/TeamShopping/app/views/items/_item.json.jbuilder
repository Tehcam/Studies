json.extract! item, :id, :label, :quantity, :is_already_bought, :rayon, :created_at, :updated_at
json.url item_url(item, format: :json)
