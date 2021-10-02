class CreateVoyages < ActiveRecord::Migration[6.0]
  def change
    create_table :voyages do |t|
      t.string :destination
      t.date :depart
      t.date :retour

      t.timestamps
    end
  end
end
