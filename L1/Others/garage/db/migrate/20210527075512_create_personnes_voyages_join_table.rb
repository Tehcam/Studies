class CreatePersonnesVoyagesJoinTable < ActiveRecord::Migration[6.0]
  def change
    create_join_table :personnes, :voyages do |t|
      # t.index [:personne_id, :voyage_id]
      # t.index [:voyage_id, :personne_id]
    end
  end
end
