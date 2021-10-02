json.extract! chanson, :id, :titre, :date_sortie, :created_at, :updated_at
json.url chanson_url(chanson, format: :json)
