class CreateAlbums < ActiveRecord::Migration[6.0]
  def change
    create_table :albums do |t|
      t.string :titre
      t.date :date_sortie

      t.timestamps
    end
  end
end
