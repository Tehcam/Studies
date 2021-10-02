json.extract! voyage, :id, :destination, :depart, :retour, :created_at, :updated_at
json.url voyage_url(voyage, format: :json)
