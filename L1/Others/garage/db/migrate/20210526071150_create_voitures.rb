class CreateVoitures < ActiveRecord::Migration[6.0]
  def change
    create_table :voitures do |t|
      t.string :immatriculation
      t.string :couleur
      t.string :marque
      t.string :modele
      t.date :date_mise_en_service

      t.timestamps
    end
  end
end
