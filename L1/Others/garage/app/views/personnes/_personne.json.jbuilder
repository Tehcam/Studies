json.extract! personne, :id, :nom, :prenom, :date_naissance, :created_at, :updated_at
json.url personne_url(personne, format: :json)
