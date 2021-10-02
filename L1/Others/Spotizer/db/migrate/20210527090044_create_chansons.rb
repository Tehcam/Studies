class CreateChansons < ActiveRecord::Migration[6.0]
  def change
    create_table :chansons do |t|
      t.string :titre
      t.date :date_sortie

      t.timestamps
    end
  end
end
